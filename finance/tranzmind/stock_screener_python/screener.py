from pandas_datareader import data as pdr
from yahoo_fin import stock_info as si
from pandas import ExcelWriter
import yfinance as yf
import pandas as pd
import requests
import datetime
import time

yf.pdr_override()

stocklist = si.tickers_sp500()
index_name = '^GSPC' # S&P 500

final = []
index = []
n = -1

exportList = pd.DataFrame(columns=['Stock', "RS_Rating", "50 Day MA", "150 Day Ma", "200 Day MA", "52 Week Low", "52 week High"])

for stock in stocklist[0:100]:
    n += 1
    time.sleep(1)
    
    print ("\npulling {} with index {}".format(stock, n))

    # RS_Rating 
    start_date = datetime.datetime.now() - datetime.timedelta(days=365)
    end_date = datetime.date.today()
    
    df = pdr.get_data_yahoo(stock, start=start_date, end=end_date)
    df['Percent Change'] = df['Adj Close'].pct_change()    
    stock_return = df['Percent Change'].sum() * 100
    
    index_df = pdr.get_data_yahoo(index_name, start=start_date, end=end_date)
    index_df['Percent Change'] = index_df['Adj Close'].pct_change()
    index_return = index_df['Percent Change'].sum() * 100
    
    RS_Rating = round((stock_return / index_return) * 10, 2)
    
    try:
        sma = [50, 150, 200]
        for x in sma:
            df["SMA_"+str(x)] = round(df.iloc[:,4].rolling(window=x).mean(), 2)

        currentClose = df["Adj Close"][-1]
        moving_average_50 = df["SMA_50"][-1]
        moving_average_150 = df["SMA_150"][-1]
        moving_average_200 = df["SMA_200"][-1]
        low_of_52week = min(df["Adj Close"][-260:])
        high_of_52week = max(df["Adj Close"][-260:])
        
        try:
            moving_average_200_20 = df["SMA_200"][-20]

        except Exception:
            moving_average_200_20 = 0

        # Condition 1: Current Price > 150 SMA and > 200 SMA
        if(currentClose > moving_average_150 > moving_average_200):
            condition_1 = True
        else:
            condition_1 = False
        # Condition 2: 150 SMA and > 200 SMA
        if(moving_average_150 > moving_average_200):
            condition_2 = True
        else:
            condition_2 = False
        # Condition 3: 200 SMA trending up for at least 1 month (ideally 4-5 months)
        if(moving_average_200 > moving_average_200_20):
            condition_3 = True
        else:
            condition_3 = False
        # Condition 4: 50 SMA> 150 SMA and 50 SMA> 200 SMA
        if(moving_average_50 > moving_average_150 > moving_average_200):
            #print("Condition 4 met")
            condition_4 = True
        else:
            #print("Condition 4 not met")
            condition_4 = False
        # Condition 5: Current Price > 50 SMA
        if(currentClose > moving_average_50):
            condition_5 = True
        else:
            condition_5 = False
        # Condition 6: Current Price is at least 30% above 52 week low (Many of the best are up 100-300% before coming out of consolidation)
        if(currentClose >= (1.3*low_of_52week)):
            condition_6 = True
        else:
            condition_6 = False
        # Condition 7: Current Price is within 25% of 52 week high
        if(currentClose >= (.75*high_of_52week)):
            condition_7 = True
        else:
            condition_7 = False
            
        # Condition 8: IBD RS_Rating greater than 70
        if(RS_Rating >= 70):
            condition_8 = True
        else:
            condition_8 = False

        if(condition_1 and condition_2 and condition_3 and condition_4 and condition_5 and condition_6 and condition_7 and condition_8):
            final.append(stock)
            index.append(n)
            
            dataframe = pd.DataFrame(list(zip(final, index)), columns =['Company', 'Index'])
            
            dataframe.to_csv('stocks.csv')
            
            exportList = exportList.append({'Stock': stock, "RS_Rating": RS_Rating ,"50 Day MA": moving_average_50, "150 Day Ma": moving_average_150, "200 Day MA": moving_average_200, "52 Week Low": low_of_52week, "52 week High": high_of_52week}, ignore_index=True)
            print (stock + " made the requirements")
    except Exception as e:
        print (e)
        print("No data on "+stock)

print(exportList)

writer = ExcelWriter("ScreenOutput.xlsx")
exportList.to_excel(writer, "Sheet1")
writer.save()
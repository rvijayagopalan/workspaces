import pandas as pd
import yfinance as yf
import pprint
# CSV file
csv_file = 'nasdaqlisted.txt'
#read cvs with pandas read_csv
df = pd.read_csv(csv_file, sep="|", skipinitialspace=True, header=None)

df = df[:-2]
df = df.iloc[1:]

for ticker in df.iloc[2600:,0]:
	print(ticker)
	tickerData = yf.Ticker(ticker)
	try:
		content = (tickerData.info)		
	except Exception as ex:
		content = ex
		#print(ticker + " - " +tickerData.info['sector'] + " - " +tickerData.info['industry'])
	open('data_nasdaq\\'+ticker+".json",'w+').write(pprint.pformat(content))

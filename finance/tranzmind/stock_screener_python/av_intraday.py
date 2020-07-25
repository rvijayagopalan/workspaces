from alpha_vantage.timeseries import TimeSeries
import matplotlib.pyplot as plt
import pandas as pd
from pandas.plotting import register_matplotlib_converters

register_matplotlib_converters()

ts = TimeSeries(key='VX39C7NJDNVB23C4',output_format='pandas')

ticker = 'MIST'

data, meta_data = ts.get_intraday(symbol=ticker,interval='5min', outputsize='full')

#df = pd.DataFrame({'x':data.index, 'y1' :data['1. open'], 'y2' :data['4. close'], 'y3' :data['5. volume']})

# multiple line plot
#plt.plot( df['x'], df['y1'], color='skyblue', linewidth=4, label='Open')
#plt.plot( df['x'], df['y2'], color='green', linewidth=4, label='Close')
#plt.plot( df['x'], df['y3'], color='yellow', linewidth=4, label='Volume')
#plt.legend()


data['4. close'].plot(label='Close')
data['5. volume'].plot(label='Volume')
plt.legend()
plt.title('Intraday TimeSeries ' + ticker)
plt.show() 
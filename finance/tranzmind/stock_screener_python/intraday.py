import requests

import pprint as pp

#Fetch Stock Data
url = 'http://api.marketstack.com/v1/eod'
params = {
    'symbols':'AAPL',
    'access_key':'e852e3fd90dfce1ecd83d523ba82f49c',
}
response = requests.request('GET',url,params=params)
pp.pprint(response.json())



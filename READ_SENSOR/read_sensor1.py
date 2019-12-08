#!/usr/bin/python
import sys

import Adafruit_DHT

#Para el envio de mensajes a traves de la api de Telegram
import requests

#Tipo de sensor empleado
sensor = Adafruit_DHT.AM2302 

#Pin usado 
pin = 4

#Datos conexion de telegram
API_TOKEN = '1034926121:AAFoaCVrgLYNpCp-QC1dusW5bstKYlVJbxM'
CHAT_ID = '13224841'
URL_BASE = 'https://api.telegram.org/bot'

# Try to grab a sensor reading.  Use the read_retry method which will retry up
# to 15 times to get a sensor reading (waiting 2 seconds between each retry).
humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)


# Note that sometimes you won't get a reading and
# the results will be null (because Linux can't
# guarantee the timing of calls to read the sensor).
# If this happens try again!
if humidity is not None and temperature is not None:
    entrada ='*************VALORES ACTUALES *************'
    print(entrada)
    datos='Temperatura={0:0.1f}°C  Humedad={1:0.1f}%'.format(temperature, humidity)
    print(datos)
    mensaje = 'Alerta! La temperatura de tu vivienda ha descendido de 20 ºC\n'
    requests.post(URL_BASE+API_TOKEN+'/sendMessage?text='+mensaje+datos+' &chat_id='+CHAT_ID+'')
    
else:
    print('Error de lectura')
    sys.exit(1)


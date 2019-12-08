#!/usr/bin/python
import sys

import Adafruit_DHT

#Para el envio de mensajes a traves de la api de Telegram
import requests

#Tipo de sensor empleado
sensor = Adafruit_DHT.AM2302 

#Pin de la Raspberry PI usado 
pin = 4

#Datos conexion de telegram
API_TOKEN = '1034926121:AAFoaCVrgLYNpCp-QC1dusW5bstKYlVJbxM'
CHAT_ID = '13224841'
URL_BASE = 'https://api.telegram.org/bot'

#Valores de alerta
TEMPERATURA_MINIMA = float('20.00')
HUMEDAD_MAXIMA = float('50.00')

# Lectura de datos desde el sensor con el metodo read_retry que intenta leer hasta 15 veces (con 2 s entre lectura)
humidity, temperature = Adafruit_DHT.read_retry(sensor, pin)

#No siempre el valor podrá leerse, en ese caso habria que volver a leer
if humidity is not None and temperature is not None:
    entrada ='*************VALORES ACTUALES *************'
    print(entrada)
    datos='Temperatura={0:0.1f}°C  Humedad={1:0.1f}%'.format(temperature, humidity)
    print(datos)
    if float(temperature) < TEMPERATURA_MINIMA:
        mensaje = 'Alerta! La temperatura de tu vivienda ha descendido de 20 ºC\n'
        print(mensaje)
        requests.post(URL_BASE+API_TOKEN+'/sendMessage?text='+mensaje+datos+' &chat_id='+CHAT_ID+'')
    if float(humidity) > HUMEDAD_MAXIMA:
        mensaje = 'Alerta! La humedad de tu vivienda ha sobrepasado el 50%\n'
        print(mensaje)
        requests.post(URL_BASE+API_TOKEN+'/sendMessage?text='+mensaje+datos+' &chat_id='+CHAT_ID+'')
        
else:
    print('Error de lectura')
    sys.exit(1)


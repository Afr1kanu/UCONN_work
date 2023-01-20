import time, _thread as thread     
from socket import *

serverName = 'localhost'
serverPort = 50007
clientSocket = socket(AF_INET, SOCK_STREAM)

clientSocket.connect((serverName,serverPort))


sentence = input("Input word with '*' in the middle:  ") # get input from user

while sentence != 'quit':
    if '*' not in sentence: # if there is no asterisk, send error message
        print("Invalid input\n")
    else:
        clientSocket.send(sentence.encode()) # send input to server

        wordlist = clientSocket.recv(10000).decode('utf-8') # get response from server
        print ("From Server:", wordlist) # print response
        print('\n')
    sentence = input("Input word with '*' in the middle:  ") # get input from user
    
clientSocket.close() # close socket
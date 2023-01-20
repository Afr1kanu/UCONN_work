from socket import *
import time

wordlist = []
with open('wordlist.txt') as f: #store wordlist in memory
    for line in f:
        wordlist.append(line.strip())

serverPort = 50007 # port number
serverSocket = socket(AF_INET,SOCK_STREAM) # create socket
serverSocket.bind(("",serverPort))

serverSocket.listen(1) # listen for connections

print("The server is ready to receive")

while 1:
    connectionSocket, addr = serverSocket.accept() # accept connection

    print('Server connected to', addr, 'on', time.ctime(time.time())) # print connection info
    
    data = connectionSocket.recv(1024).decode('utf-8') # get data from client
    if '*' not in data: # if there is no asterisk, send error message
        invalid = "Invalid input"
        connectionSocket.send(invalid.encode())
        connectionSocket.close()
    else:
        words_with_asterisk = data.strip().split('*') # split on asterisk
        check_first_word = words_with_asterisk[0] # first part of word
        check_rest = words_with_asterisk[1] # rest of word
        res = [idx for idx in wordlist if idx.lower().startswith(check_first_word.lower()) and idx.lower().endswith(check_rest.lower())] # find words that start with first word and end with rest of word
        if len(res) == 0:
            reply = "No words found"
        else:
            reply = str(res) # convert to string and send back
        time.sleep(5) # simulate latency
        connectionSocket.send(reply.encode()) # send it to client
        connectionSocket.close()
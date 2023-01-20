"""
Server side: open a socket on a port, listen for a message from a client,
and send an echo reply; echoes lines until eof when client closes socket;
spawns a thread to handle each client connection; threads share global
memory space with main thread; this is more portable than fork: threads
work on standard Windows systems, but process forks do not;
"""

import time, _thread as thread           # or use threading.Thread().start()
from socket import *                     # get socket constructor and constants

wordlist = []
with open('wordlist.txt') as f: #store wordlist in memory
    for line in f:
        wordlist.append(line.strip())
        
myHost = ''                              # server machine, '' means local host
myPort = 50007                           # listen on a non-reserved port number

sockobj = socket(AF_INET, SOCK_STREAM)           # make a TCP socket object
sockobj.bind((myHost, myPort))                   # bind it to server port number
sockobj.listen(5)                                # allow up to 5 pending connects
print("The server is ready to receive")

def now():
    return time.ctime(time.time())               # current time on the server

def handleClient(connection):                    # in spawned thread: reply
    time.sleep(5)                                # simulate a blocking activity
    while True:                                  # read, write a client socket
        data = connection.recv(1024).decode('utf-8')
        if not data: break                  
        words_with_asterisk = data.strip().split('*') # split on asterisk
        check_first_word = words_with_asterisk[0] # first part of word
        check_rest = words_with_asterisk[1] # rest of word
        res = [idx for idx in wordlist if idx.lower().startswith(check_first_word.lower()) and idx.lower().endswith(check_rest.lower())] # find words that start with first word and end with rest of word
        if len(res) == 0:
            reply = "No words found"
        else:
            reply = str(res) # convert to string and send back
        connection.send(reply.encode()) # send it to client
    connection.close()

def dispatcher():                                # listen until process killed
    while True:                                  # wait for next connection,
        connection, address = sockobj.accept()   # pass to thread for service
        print('Server connected by', address, end=' ')
        print('at', now())
        thread.start_new_thread(handleClient, (connection,)) # start a thread

dispatcher()

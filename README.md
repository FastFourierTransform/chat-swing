# chat-swing
Real time chat working over the network using to demonstrate the [client-server-library](https://github.com/FastFourierTransform/client-server-library) functionality.

## Features
Simple server side without GUI, one server handle one chat group.
Client side with GUI in java swing, different clients comunicate with each other that are linked to one server
In high level all communications are send in json format

### Json protocol
```
{command:(command),src:(sender),[msg:message]}
Command:
 * enter
 * leave
 * message
``` 
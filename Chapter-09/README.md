# Ch. 9 - Input and Output
Java provides a lot of stream classes to read and write data.

## Stream
In the computer system, there are data **source** (file, network, ...) and **destination**.
Anything on files can be the source, the destination, or both of them. Stream is a continuous flow of data, a FIFO, and a one-way structure.
It connects the source and destination strongly.

## Types of Stream
According to the processing data, stream is divided into **byte stream** and **character stream**.
In addition, by the usage of the stream, it is also categorized as **data sink stream** and **data processing stream**.

### 1. Byte vs Character
#### Byte Stream
I/O stream for video or image files.
Its unit is a byte, (8-bit) and classes using names with "InputStream" or "Outstream" belong to it.
#### Character Stream
I/O stream for text data, processing by 2-byte (16-bit) Unicode character unit.
The name of the classes for it with "Reader" or "Writer".

### 2. Sink vs Processing
#### Data Sink Stream
(=Node Stream) I/O stream that directly processes the data from the source like memories, pipes, and files.
#### Data Processing Stream
(=Filter Stream) I/O stream doing a special things while processing, such as buffering, filtering, stream merging, object serialization, data conversion, and conversion between bytes and characters.

## Stream Class
### Input Stream Class
Input stream class represents a stream to input data on memory. Data sink stream can be connected with data processing stream.

    FileOutputStream fout = new FileOutputStream("data.txt");   // FileOutputStream is a data sink stream.
    DataOutputStream dout = new DataOutputStream(fout);   // DataOutputStream is a data processing stream.
    
InputStream and Reader are abstract classes which are similar to each other. While the unit of InputStream is a byte, Reader takes the unit as 2 bytes. Here are some matching classes between them.

| Class Name | Corresponding Class | Description |
| :-: | :-: | :-: |
| BufferedInputStream | BufferedReader | Have a buffer function. |
| DataInputStream | | Input for primitive type data. |
| FileInputStream | FileReader | File input. |
| FilterInputStream | FilterReader | Root of filter classes. |
| InputStream | Reader | Default input stream. |

### Output Stream Class
Output stream class provides the function to output data from the memory.

OutputStream (1-byte) and Writer (2-bytes) are also resemble each other.

| Class Name | Corresponding Class | Description |
| :-: | :-: | :-: |
| BufferedOutputStream | BufferedWriter | Have a buffer function. |
| DataOutputStream | | Output for primitive type data. |
| FileOutputStream | FileWriter | File output. |
| PrintStream | PrintWriter | Standard output. |
| OutputStream | Writer | Default output stream. |

## Byte I/O Stream
### Byte Input Stream

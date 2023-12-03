import numpy as np
# import pandas as pd


def arrayComparison():
    a1 = range(1000)
    a1 = [a1[i] for i in a1 ]
    a2 = np.arange(1000)
    print(a1,"\n\n\n\n")
    print(a2)
def arrayObject():
    ar = np.array([[9,6],[1,4],[3,7],[8,2],[4,5]])
    print("Array")
    print(ar)
    print("Dimensions")
    print(ar.ndim)
    print("Bytes")
    print(ar.itemsize) ## bytes
    print("Size")
    print(ar.size) # length size
    print("Shape")
    print(ar.shape) # Tuple (Row, Column)
    print("Zeros Array")
    ar = np.zeros((5,10)) # zeros (Row, Column)
    print(ar) 
    print("Type")
    print(type(ar[0][0]))
    print("Ones Array")
    ar = np.ones((5,10)) # ones (Row, Column)
    print(ar) 
    print("A Range")
    ar = np.arange(1000) # range sequence fillup
    print(ar) 
    print("Array Linspace")
    ar = np.linspace(1,6,6) # linspace
    print(ar) 
    print("Reshape") 
    ar = np.ones((6,3)) # Reshaping array
    print(ar.reshape(3,6)) 
    print("Ravel") 
    ar = ar.ravel() # flaten array
    print(ar) 

    ar = np.array([[1,2,3],[4,57,8]])
    print("Sum\n",ar.sum()) # sum
    print("Min\n",ar.min()) # Min
    print("Max\n",ar.max()) # Max
    print("Sum Axis 1\n",ar.sum(axis=1)) # horizontal sum
    print("Sum Axis 2\n",ar.sum(axis=0)) # vertical sum
    print("Sqrt: \n",np.sqrt(ar)) # Square Root
    print("Standard Deviation: \n",np.std(ar)) # Standard Deviation
    print("Addition: \n",(ar+ar)) # Addition
    print("Subtraction: \n",(ar-ar)) # Subtraction
    print("Division: \n",(ar/ar)) # Division
    print("Multiplication: \n",(ar*ar)) # Multiplication
    
    
if __name__ == "__main__":
    df = open("nyc_weather.csv","r")
    print(df.read())
    # dictionary = {
    #     "1":1,
    #     "2":2
    # }
    # pd.DataFrame(dictionary)
    # print(pd)
    arrayObject()

# Whatever
It's a repo that contains whatever.

#### Results

###### PreVsPostIncrementDecrementTest
[link](https://github.com/fru1tstand/whatever/blob/master/src/me/fru1t/whatever/PreVsPostIncrementDecrementTest.java)  
Pre decrement test  
Pre increment test  
Post decrement test  
Post increment test  
  
pre decrement average:	1063857.6890000019ns for 1000000 calculations  
post decrement average:	1159826.6520000012ns for 1000000 calculations  
  
pre increment average:	1080756.898999999ns for 1000000 calculations  
post increment average:	1342700.5470000003ns for 1000000 calculations  

###### StaticAccessToNonStaticMethod
[link](https://github.com/fru1tstand/whatever/blob/master/src/me/fru1t/whatever/StaticAccessToNonStaticMethod.java)
I was confused on what was produced with the following code:  
```
Class TestClass {
	public static staticMethod();
	public void nonStaticMethod();
}

TestClass::staticMethod
TestClass::nonStaticMethod
```
package edu.hrbeu.ParcelMathServiceDemo;
 
import edu.hrbeu.ParcelMathServiceDemo.AllResult;
 
interface IMathService {        
    long Add(long a, long b);           
	AllResult ComputeAll(long a, long b);
} 
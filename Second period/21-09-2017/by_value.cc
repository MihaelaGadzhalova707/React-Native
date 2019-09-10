#include <iostream>
using namespace std;

void fun(int& value) {
	cout << "input value = " << value << endl;
	value = 45;
	cout << "output value = " << value << endl;
}

int main() {
	int b = 15;
	fun(b);
	cout << "b= " << b << endl;
	return 0;
}	

#include <iostream>
#include <list>
using namespace std;

int main() {
	list<int> l1;
	l1.push_front(666);
	cout << l1.back() << endl;
	return 0;
}

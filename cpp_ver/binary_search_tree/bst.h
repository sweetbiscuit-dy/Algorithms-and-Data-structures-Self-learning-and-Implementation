#include <iostream>

using namespace std;

template<typename E>
class BST<E> {
public:
	int _size;
	Node _root;
public:
	BST() : _size(0), _root(nullptr) {}
private:
	class Node<E> {
		E e;
		Node left;
		Node right;
	};
};

---
title: 1override
---

{% raw %}
https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/

```python
class Node {
public:
    virtual ~Node () {};
    virtual int evaluate() const = 0;
protected:
    // define your fields here
};

class CustomNode : public Node {
public:
    string val;
    Node *left, *right;

    CustomNode(string v) : val(v), left(nullptr), right(nullptr) {}

    int evaluate() const override {
        if (val == "+") return left->evaluate() + right->evaluate();
        if (val == "-") return left->evaluate() - right->evaluate();
        if (val == "*") return left->evaluate() * right->evaluate();
        if (val == "/") return left->evaluate() / right->evaluate();
        return stoi(val); // it's a number
    }
};


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree representing it as a Node.
 */

class TreeBuilder {
public:

Node* postfixToExpressionTree(vector<string>& postfix) {
    if (postfix.empty()) {
        return nullptr;
    }

    stack<CustomNode*> s;

    for (string st : postfix) {
        if (st=="+" or st=="-" or st=="/" or st=="*") { 
            CustomNode* rightChild = s.top();
            s.pop();
            CustomNode* leftChild = s.top();
            s.pop();

            CustomNode* operatorNode = new CustomNode(st);
            operatorNode->left = leftChild;
            operatorNode->right = rightChild;
            s.push(operatorNode);
        } 
        else{
            s.push(new CustomNode(st));
        }
    }
    return s.top();
}

    Node* buildTree(vector<string>& postfix) {
        return postfixToExpressionTree(postfix);
    }
};
```
{% endraw %}

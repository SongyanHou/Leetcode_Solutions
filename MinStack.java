class MinStack {
    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    //could use arrayList to represent a stack
    //add or remove method
    //build another stack to store the minimum value
    //be careful about popping the min value!
    public void push(int x) {
        stack.add(x);
        if(minStack.isEmpty() || minStack.get(minStack.size()-1)>=x){
            minStack.add(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int num=stack.remove(stack.size()-1);
        if(!minStack.isEmpty() && num==minStack.get(minStack.size()-1)){
            minStack.remove(minStack.size()-1);
        }
        
    }

    public int top() {
        if(!stack.isEmpty())
            return stack.get(stack.size()-1);
        
        return 0;
    }

    public int getMin() {
        if(!stack.isEmpty())
            return minStack.get(minStack.size()-1);
    
        return 0;
    }
}
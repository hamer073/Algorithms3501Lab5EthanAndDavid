package node_helper;

public class IntNode{
  private int value;
  private IntNode parent;
  private IntNode[] children;

  public IntNode(int value, IntNode parent) {
    this.value = value;
    this.parent = parent;

    //parent.addChild(this);
  }

/*
  private void addChild(IntNode newChild){
    IntNode[] tempArray = new IntNode[this.children.length + 1];
    for(int i = 0; i < this.children.length; i++){
      tempArray[i] = this.children[i];
    }
    tempArray[tempArray.length - 1] = newChild;
    this.children = tempArray;
  }
  */

  public IntNode getParent(){ return this.parent; }
  //public IntNode[] getChildren(){ return this.children; }
  public int getValue(){ return this.value; }
  public void setValue(int newValue){ this.value = newValue; }
}

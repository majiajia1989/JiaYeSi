package com.e1858.wuye.pojo;

import java.util.ArrayList;


public class TreeNode
{
    private String id;
    private String text;
    private ArrayList<TreeNode> children;
    
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public ArrayList<TreeNode> getChildren()
	{
		return children;
	}
	public void setChildren(ArrayList<TreeNode> children)
	{
		this.children = children;
	}

    
}
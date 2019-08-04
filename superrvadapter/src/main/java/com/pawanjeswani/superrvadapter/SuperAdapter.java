package com.pawanjeswani.superrvadapter;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class SuperAdapter extends RecyclerView.Adapter {
    protected List<Object> baseList = new ArrayList<>();
    protected List<DummyObject> otherViewPositions = new ArrayList<>();
    protected boolean resetData = false;

    private int lastSearchedIndex = 0;

    public SuperAdapter() {
        super();
    }

    public SuperAdapter(List<DummyObject> otherViewPositions) {
        Collections.sort( otherViewPositions);
        this.otherViewPositions = otherViewPositions;

    }

    protected abstract void createOtherItemList();

    public void setResetData(boolean resetData) {
        this.resetData = resetData;
    }

    @Override
    public int getItemCount() {
        return baseList.size();
    }

    @Override
    public int getItemViewType(int position) {
        //todo: fill logic for viewtype

        if(otherViewPositions.size()>0 && baseList.size()>0 && baseList.get(position) instanceof DummyObject)
            return ((DummyObject)baseList.get(position)).itemViewType;
        else{

            return -1;
        }
    }

    public void setBaseList(List<?> baseList) {
        if (resetData) {
            this.baseList.clear();
            resetData = false;
            this.lastSearchedIndex = 0;
        }
        this.baseList.addAll(baseList);
        checkItemToBeInserted();

    }

    private void checkItemToBeInserted(){
        int localSearchIndex = this.lastSearchedIndex;
        for (int i = localSearchIndex; i < otherViewPositions.size(); i++) {

            if(otherViewPositions.get(i).getPosition()<=baseList.size()){

                baseList.add(otherViewPositions.get(i).getPosition(),otherViewPositions.get(i));
                this.lastSearchedIndex = i+1;

            }
        }
    }


    public class DummyObject implements Comparable<DummyObject> {
        int itemViewType;
        int position;

        public DummyObject(int itemViewType, int position) {
            this.itemViewType = itemViewType;
            this.position = position;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int positionInOtherList) {
            this.position = positionInOtherList;
        }

        @Override
        public int compareTo(DummyObject emp) {
            //let's sort the employee based on id in ascending order
            //returns a negative integer, zero, or a positive integer as this employee id
            //is less than, equal to, or greater than the specified object.
            return (this.position - emp.position);
        }
    }
}


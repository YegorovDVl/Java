package LinkedArrayList;


import java.util.*;

public class LinkedArrayList<T> implements Deque<T> {
    private int sizeCounter;
    private final int Capacity = 1000;
    private   ArrayContainer<T> Last = null;
    private ArrayContainer<T> First = null;
    private ArrayContainer<T> PreviousAddLast =  null;
    private ArrayContainer<T> PreviousAddFirst =  null;

    private static class ArrayContainer<T>{
        private final Object[] DataArray = new Object[5];
        ArrayContainer<T> PreviousContainer;
        ArrayContainer<T> NextContainer;
        private ArrayContainer(T Data, int index, ArrayContainer<T> Previous, ArrayContainer<T> Next){
            DataArray[index] = Data;
            this.PreviousContainer = Previous;
            this.NextContainer = Next;
        }
    }

    private int getIndexFirst (ArrayContainer<T> Container){
        if (Container != null) {
            int answer = 0;
            int indexFirst = 4;
            int index = 0;
            while (Container.DataArray[indexFirst]==null){
                indexFirst--;
            }
            while (Container.DataArray[indexFirst-index] != null) {
                answer = indexFirst-index;
                index++;
                if ((indexFirst-index) == -1){
                    return answer;
                }
            }
            return answer;
        } else {
            throw new NullPointerException();
        }
    }

    private int getIndexLast (ArrayContainer<T> Container){
        if (Container != null) {
            int answer = 0;
            int indexFirst = 0;
            int index = 0;
                while (Container.DataArray[indexFirst]==null){
                    indexFirst++;
                }
                while (Container.DataArray[index+indexFirst] != null) {
                    answer = index+indexFirst;
                    index++;
                    if ((index+indexFirst) == 5){
                        return answer;
                    }
                }
            return answer;
            } else {
            throw new NullPointerException();
        }
    }

    private T getOne(int Index){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(First == null){
            First = Last;
        }
        ArrayContainer<T> Getter = First;
        int Counter = (Index+getIndexFirst(First))/5;
        if(Counter == 0){
            return (T) Getter.DataArray[Index+getIndexFirst(First)];
        } else{
            for (int i = 0; i < Counter; i++){
                Getter = Getter.NextContainer;
            }
            return (T) Getter.DataArray[(Index+getIndexFirst(First)) % 5];
        }
    }

    private void setOne(int index, T Data){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(First == null){
            First = Last;
        }
        ArrayContainer<T> Getter = First;
        int Counter = (index+getIndexFirst(First))/5;
        if(Counter == 0){
            Getter.DataArray[index+getIndexFirst(First)] = Data;
        } else{
            for (int i = 0; i < Counter; i++){
                Getter = Getter.NextContainer;
            }
            Getter.DataArray[(index+getIndexFirst(First)) % 5] = Data;
        }
    }

    private int getFirstOccurrence(T Data){
            for (int i = 0; i < this.size(); i++) {
                if (getOne(i).equals(Data)) {
                    return i;
                }
            }
            return -1;
    }

    private int getLastOccurrence(T Data){
        int counter = 0;
        for (int i = 0; i < this.size(); i++) {
            if (getOne(i).equals(Data)) {
                counter++;
            }
        }
        for (int i = 0; i < this.size(); i++) {
            if (getOne(i).equals(Data)) {
                counter--;
                if (counter == 0){
                    return i;
                }
            }
        }
        return -1;
    }

    public void removeByIndex (int index){
        while (index > 0){
            setOne(index, getOne(index-1));
            index--;
        }
        removeFirst();
    }

    @Override
    public void addFirst(T Data){
        if(sizeCounter == Capacity){
            throw new IllegalStateException();
        }
        if(Data == null){
            throw new NullPointerException();
        }
        sizeCounter++;
        if(First == null){
            First = new ArrayContainer<>(Data, 4, null, null);
            if (Last != null){
                First.NextContainer = Last;
                Last.PreviousContainer = First;
            }
        } else {
            if ((getIndexFirst(First)-1) >= 0) {
                First.DataArray[getIndexFirst(First)-1] = Data;
            } else {
                PreviousAddFirst = First;
                First = new ArrayContainer<T>(Data, 4, null, PreviousAddFirst);
                PreviousAddFirst.PreviousContainer = First;
                if (Last == null){
                    Last = PreviousAddFirst;
                }
            }
        }
    }

    @Override
    public void addLast(T Data){
        if(sizeCounter == Capacity){
            throw new IllegalStateException();
        }
        if(Data == null){
            throw new NullPointerException();
        }
        sizeCounter++;
        if(Last == null){
            Last = new ArrayContainer<T>(Data, 0, null, null);
            if (First != null){
                Last.PreviousContainer = First;
                First.NextContainer = Last;
            }
        } else {
            if ((getIndexLast(Last)+1) < 5) {
                Last.DataArray[getIndexLast(Last)+1] = Data;
            } else {
                PreviousAddLast = Last;
                Last = new ArrayContainer<T>(Data, 0, PreviousAddLast, null);
                PreviousAddLast.NextContainer = Last;
                if (First == null){
                    First = PreviousAddLast;
                }
            }
        }
    }

    @Override
    public boolean offerFirst(T Data) {
        try{
            addFirst(Data);
            return true;
        } catch (IllegalStateException err){
            return false;
        }
    }

    @Override
    public boolean offerLast(T Data) {
        try{
            addLast(Data);
            return true;
        } catch (IllegalStateException err){
            return false;
        }
    }

    @Override
    public T removeFirst(){
        T Output = null;
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            if (First == null){
                First = Last;
            }
            sizeCounter--;
            Output = (T) First.DataArray[getIndexFirst(First)];
            if ((getIndexFirst(First) == 4) & (sizeCounter != 0)) {
                First = First.NextContainer;
                PreviousAddFirst = First.NextContainer;
                First.PreviousContainer = null;
            } else if (sizeCounter == 0) {
                First = null;
                Last = null;
            } else {
                First.DataArray[getIndexFirst(First)] = null;
            }
            return Output;
        }
    }

    @Override
    public T removeLast(){
        T Output = null;
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            if (Last == null){
                Last = First;
            }
            sizeCounter--;
            Output = (T) Last.DataArray[getIndexLast(Last)];
            if ((getIndexLast(Last) == 0)& (sizeCounter!= 0)) {
                Last = Last.PreviousContainer;
                PreviousAddLast = Last.PreviousContainer;
                Last.NextContainer = null;
            } else if (sizeCounter == 0) {
                First = null;
                Last = null;
            } else {
                Last.DataArray[getIndexLast(Last)] = null;
            }
        }
        return Output;
    }

    @Override
    public T pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException err){
            return null;
        }
    }

    @Override
    public T pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException err){
            return null;
        }
    }

    @Override
    public T getFirst() {
        return getOne(0);
    }

    @Override
    public T getLast() {
        return getOne(this.size() - 1);
    }

    @Override
    public T peekFirst() {
        try{
            return getFirst();
        } catch (NoSuchElementException err){
            return null;
        }
    }

    @Override
    public T peekLast() {
        try{
            return getLast();
        } catch (NoSuchElementException err){
            return null;
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object Data) {
        if (Data == null){
            throw new NullPointerException();
        }
        int index = getFirstOccurrence((T) Data);
        if (contains(Data)){
            if (index == 0){
                removeFirst();
            } else if (index == (this.size()-1)){
                removeLast();
            } else{
                while (index > 0){
                    setOne(index, getOne(index-1));
                    index--;
                }
                removeFirst();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeLastOccurrence(Object Data) {
        if (Data == null){
            throw new NullPointerException();
        }
        int index = getLastOccurrence((T) Data);
        if (contains(Data)){
            if (index == 0){
                removeFirst();
            } else if (index == (this.size()-1)){
                removeLast();
            } else{
                while (index > 0){
                    setOne(index, getOne(index-1));
                    index--;
                }
                removeFirst();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(T Data) {
        addLast(Data);
        return true;
    }

    @Override
    public boolean offer(T Data) {
        return offerLast(Data);
    }

    @Override
    public T remove() {
        return removeFirst();
    }

    @Override
    public T poll() {
        return pollFirst();
    }

    @Override
    public T element() {
        return getFirst();
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public boolean addAll(Collection<? extends T> collectionData) {
        Iterator<T> iter = (Iterator<T>) collectionData.iterator();
        while (iter.hasNext()){
            addLast(iter.next());
        }
        return true;
    }

    @Override /* **/
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override /* **/
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override /* **/
    public void clear() {

    }

    @Override
    public void push(T Data) {
        addFirst(Data);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object Data) {
        removeFirstOccurrence(Data);
        return true;
    }

    @Override /* **/
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object Data) {
        if (Data == null){
            throw new NullPointerException();
        }
        boolean flag = false;
        for (int i = 0; i < size(); i++){
            if (getOne(i).equals(Data)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public int size(){
        return sizeCounter;
    }

    @Override
    public boolean isEmpty() {
        return ((First == null) && (Last == null));
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int cursor;
        int lastRet = -1;

        Itr() {
        }

        public boolean hasNext() {
            return cursor != size();
        }

        public T next() {
            int i = cursor;
            if (i >= size())
                throw new NoSuchElementException();
            cursor = i + 1;
            return (T) getOne(lastRet = i);
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            try {
                removeByIndex(lastRet);
                cursor = lastRet;
                lastRet = -1;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override /* **/
    public Object[] toArray() {
        return new Object[0];
    }

    @Override /* **/
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }
}

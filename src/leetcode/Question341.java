package leetcode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 341. 扁平化嵌套列表迭代器
 */
public class Question341 {


    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private Deque<ListIterator<NestedInteger>> stack;


        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            if (nestedList != null) {
                stack.addFirst(nestedList.listIterator());
            }
        }


        @Override
        public Integer next() {
            return stack.getFirst().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                final ListIterator<NestedInteger> it = stack.getFirst();
                if (it.hasNext()) {
                    final NestedInteger next = it.next();
                    if (next.isInteger()) {
                        it.previous();
                        return true;
                    } else {
                        stack.addFirst(next.getList().listIterator());
                    }
                } else {
                    stack.removeFirst();
                }
            }

            return false;

        }

    }

}

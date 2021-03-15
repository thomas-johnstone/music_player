package music_player;

/**
 * Interface to specify the order of traversing the element in a collection
 */
public interface playOrder {
    /**
     * Return the index of the next element in the collection
     * based on the specific traversing method.
     * @return the index of the next element in the collection
     */
    int getNext();
    /**
     * Check if all element in the collection has been traversed.
     * @return true if the collection has more element to traverse
     */
    boolean hasNext();
}

/**
 * The Observer interface represents an observer in the observer pattern.
 * Objects implementing this interface can subscribe to and receive updates from
 * subjects they are observing.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;
/**
 * Update method called by the subject to notify the observer about a change.
 *
 * @param newsItem The identifier or information about the updated news.
 */
public interface Observer {
    void update(int newsItem);
}
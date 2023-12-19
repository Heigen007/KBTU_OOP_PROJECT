/**
 * The ComparatorByArticlesLength class is a comparator for ResearchPaper objects,
 * specifically comparing them based on the number of pages.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import universityProject.dev.research.ResearchPaper;

public class ComparatorByArticlesLength extends ResearchPaperComporator {
	/**
     * Compares two ResearchPaper objects based on the number of pages.
     *
     * @param paper1 The first ResearchPaper object to compare.
     * @param paper2 The second ResearchPaper object to compare.
     * @return An integer representing the result of the comparison:
     *         - a negative value if paper1 has fewer pages than paper2,
     *         - 0 if both papers have the same number of pages,
     *         - a positive value if paper1 has more pages than paper2.
     */
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getPagesNumber(), paper2.getPagesNumber());
    }
}
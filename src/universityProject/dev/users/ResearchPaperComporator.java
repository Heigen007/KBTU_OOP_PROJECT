/**
 * The ResearchPaperComparator class implements the Comparator interface for comparing ResearchPaper objects.
 * It compares research papers based on the number of citations they have.
 *
 * @version 1.0
 * @author Zhanibek
 */
package universityProject.dev.users;

import java.util.Comparator;
import universityProject.dev.research.ResearchPaper;

public class ResearchPaperComporator implements Comparator<ResearchPaper> {
	/**
     * Compares two research papers based on their number of citations.
     *
     * @param paper1 The first research paper to compare.
     * @param paper2 The second research paper to compare.
     * @return The result of the comparison based on the number of citations.
     */
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getCitationsNumber(), paper2.getCitationsNumber());
    }
}
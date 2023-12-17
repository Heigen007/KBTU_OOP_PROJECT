package universityProject.dev.users;

import universityProject.dev.research.ResearchPaper;

public class ComparatorByArticlesLength extends ResearchPaperComporator {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getPagesNumber(), paper2.getPagesNumber());
    }
}
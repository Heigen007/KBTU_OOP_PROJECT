package universityProject.dev.users;

import universityProject.dev.research.ResearchPaper;

public class ComparatorByCitations extends ResearchPaperComporator {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getCitationsNumber(), paper2.getCitationsNumber());
    }
}
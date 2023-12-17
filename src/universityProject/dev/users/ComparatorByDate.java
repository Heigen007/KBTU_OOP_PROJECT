package universityProject.dev.users;

import universityProject.dev.research.ResearchPaper;

public class ComparatorByDate extends ResearchPaperComporator {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return paper1.getPublicationDate().compareTo(paper2.getPublicationDate());
    }
}
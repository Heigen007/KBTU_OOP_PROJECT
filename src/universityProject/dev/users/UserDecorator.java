package universityProject.dev.users;

import universityProject.dev.dataRepo.DataRepository;

public abstract class UserDecorator {
    protected Integer decoratedUser;

    public UserDecorator() {
    }
    public UserDecorator(Integer decoratedUser) {
        this.decoratedUser = decoratedUser;
    }

    public User getDecoratedUser() {
        return DataRepository.getUserById(this.decoratedUser);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserDecorator other = (UserDecorator) obj;
        return decoratedUser == other.decoratedUser;
    }
}
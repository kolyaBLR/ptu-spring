package by.bsuir.db.baseuser;

public enum BaseUserType {
    user("user"),
    enterpreneur("enterpreneur"),
    moderator("moderator"),
    admin("admin");

    final public String value;

    BaseUserType(String value)
    {
        this.value = value;
    }
}

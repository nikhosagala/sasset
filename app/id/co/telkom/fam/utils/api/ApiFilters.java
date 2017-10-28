package id.co.telkom.fam.utils.api;

public class ApiFilters {
    private String logic;
    private ApiFilter[] filters;

    String getLogic() {
        return logic;
    }

    @SuppressWarnings("unused")
    public void setLogic(String logic) {
        this.logic = logic;
    }

    ApiFilter[] getFilters() {
        return filters;
    }

    @SuppressWarnings("unused")
    public void setFilters(ApiFilter[] filters) {
        this.filters = filters;
    }

}

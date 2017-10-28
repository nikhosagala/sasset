package id.co.telkom.fam.models.json;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Menu {
    public String title;
    public String link;
    public String url;
    public String icon;
    public List<Menu> children;
    public boolean home;
    public boolean group;

    public Menu(String title, boolean group) {
        this.title = title;
        this.group = group;
    }

    public Menu(String title, String link, String icon, boolean home) {
        this.title = title;
        this.link = link;
        this.icon = icon;
        this.home = home;
    }

    public Menu(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public Menu(String title, String link, String icon, List<Menu> children) {
        this.title = title;
        this.link = link;
        this.icon = icon;
        this.children = children;
    }
}

package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private String articleName;
    private String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleText() {
        return articleText;
    }

    @Override
    public String toString() {
        return "Название статьи: " + articleName + "\n" +
                "Текст статьи:" + articleText;

    }

    @Override
    public String getSearchTerm() {
        return articleName + ":" + articleText;
    }

    @Override
    public String getContentType() {
        return "Article";
    }

    @Override
    public String getName() {
        return articleName;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleName);
    }
}

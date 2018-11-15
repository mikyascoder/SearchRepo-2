package com.mcs.mikyas.searchrepo.Model;

public class Repository {
    private  String repositoryName;
    private String avatarUrl;
    private Double score;

    public Repository(String repositoryName, String avatarUrl, Double score) {
        this.repositoryName = repositoryName;
        this.avatarUrl = avatarUrl;
        this.score = score;
    }

    public String getRepositoryName() {

        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Repository{" +
                "repositoryName='" + repositoryName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", score=" + score +
                '}';
    }
}

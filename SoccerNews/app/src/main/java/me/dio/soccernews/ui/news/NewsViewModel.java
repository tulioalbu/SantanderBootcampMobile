package me.dio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.dio.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        news = new MutableLiveData<>();

        List<News> news = new ArrayList<>();
        news.add(new News("Karla tem sondagem de time da China", "Atacante alvirrubra fez 43 gols na temporada."));
        news.add(new News("Santa Cruz empata com Souza/PB", "No campeonato do Nordeste de futebol feminino, times estrearam empatados"));
        news.add(new News("Retrô consegue accesso à série C", "15 vitórias depois, o time alcançou o objetivo."));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}
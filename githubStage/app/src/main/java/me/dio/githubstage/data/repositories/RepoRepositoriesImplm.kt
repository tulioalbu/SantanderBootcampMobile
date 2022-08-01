package me.dio.githubstage.data.repositories

import kotlinx.coroutines.flow.flow
import me.dio.githubstage.data.model.Repo
import me.dio.githubstage.data.services.GithubService

class RepoRepositoriesImpl (private val service: GithubService): RepoRepository {

    override suspend fun listRepositories(user: String) = flow<List<Repo>> {
        val repoList = service.listRepositories(user)
        emit(repoList)

    }
}
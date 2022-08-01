package me.dio.githubstage.domain

import kotlinx.coroutines.flow.Flow
import me.dio.githubstage.core.UseCase
import me.dio.githubstage.data.model.Repo
import me.dio.githubstage.data.repositories.RepoRepository

class ListUserRepositoriesUseCase (private val repository: RepoRepository) : UseCase<String, List<Repo>>() {
    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }


}
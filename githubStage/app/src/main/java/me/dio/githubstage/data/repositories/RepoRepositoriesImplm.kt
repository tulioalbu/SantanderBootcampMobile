package me.dio.githubstage.data.repositories

import kotlinx.coroutines.flow.flow
import me.dio.githubstage.core.RemoteException
import me.dio.githubstage.data.services.GithubService
import retrofit2.HttpException

class RepoRepositoriesImpl (private val service: GithubService): RepoRepository {

    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Erro na busca")
        }

    }
}
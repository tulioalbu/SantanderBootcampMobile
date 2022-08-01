package me.dio.githubstage.data.repositories

import kotlinx.coroutines.flow.Flow
import me.dio.githubstage.data.model.Repo

interface RepoRepository {

    suspend fun listRepositories(user: String) : Flow<List<Repo>>
}
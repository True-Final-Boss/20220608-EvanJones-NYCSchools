// Generated by Dagger (https://dagger.dev).
package com.example.a20220608_evanjones_nycschools.view.activities;

import com.example.a20220608_evanjones_nycschools.model.repository.Repository;

import javax.inject.Provider;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<Repository> repositoryProvider;

  public MainActivity_MembersInjector(Provider<Repository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<Repository> repositoryProvider) {
    return new MainActivity_MembersInjector(repositoryProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectRepository(instance, repositoryProvider.get());
  }

  @InjectedFieldSignature("com.example.a20210909_evanjones_nycschools.view.MainActivity.repository")
  public static void injectRepository(MainActivity instance, Repository repository) {
    instance.repository = repository;
  }
}
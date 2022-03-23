package com.example.demoquerydsl.jpa;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.Tuple;
import com.querydsl.core.dml.DeleteClause;
import com.querydsl.core.dml.InsertClause;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;

import javax.persistence.EntityManager;

public class JPAQueryFactory implements QueryFactory<JPQLQuery<?>>, JPQLQueryFactory {

    public JPAQueryFactory(EntityManager em) {

    }

    @Override
    public DeleteClause<?> delete(EntityPath<?> entityPath) {
        return null;
    }

    @Override
    public <T> JPQLQuery<T> select(Expression<T> expression) {
        return null;
    }

    @Override
    public JPQLQuery<Tuple> select(Expression<?>... expressions) {
        return null;
    }

    @Override
    public <T> JPQLQuery<T> selectDistinct(Expression<T> expression) {
        return null;
    }

    @Override
    public JPQLQuery<Tuple> selectDistinct(Expression<?>... expressions) {
        return null;
    }

    @Override
    public JPQLQuery<Integer> selectOne() {
        return null;
    }

    @Override
    public JPQLQuery<Integer> selectZero() {
        return null;
    }

    @Override
    public <T> JPQLQuery<T> selectFrom(EntityPath<T> entityPath) {
        return null;
    }

    @Override
    public JPQLQuery<?> from(EntityPath<?> entityPath) {
        return null;
    }

    @Override
    public JPQLQuery<?> from(EntityPath<?>... entityPaths) {
        return null;
    }

    @Override
    public UpdateClause<?> update(EntityPath<?> entityPath) {
        return null;
    }

    @Override
    public InsertClause<?> insert(EntityPath<?> entityPath) {
        return null;
    }

    @Override
    public JPQLQuery<?> query() {
        return null;
    }
}

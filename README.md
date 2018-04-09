# ElasticSearch 客户端插件

## 优势
不用各种了解ES的版本及内部参数调用，只需要通过简单的类Sql及ORM的查询方式即可针对ES来进行数据获取

## 示例
```
/**
 * 该repository是抽象的，调用方可自行继承并重写
 */
@Autowired
AbstractRepository<String> repository;
//step 1 实例化ES标准查询对象
QueryCriteria criteria = new QueryCriteria();
//step 2 确定排序规则
List<OrderColumn> orderColumns = Lists.newArrayList();
OrderColumn column = new OrderColumn();
column.setColumnName("insertTime");
column.setSorting(DataSorting.Descending);
orderColumns.add(column);

//step 3 设置查询条件
List<FilterColumn> filters = Lists.newArrayList();
if (StringUtils.isNotBlank("filterColumn")) {
    FilterColumn filterColumn = new FilterColumn();
    filterColumn.setColumnName("filterColumn");
    filterColumn.setComparison(Comparison.Equals);
    filterColumn.setValue("columnValue");
    filters.add(filterColumn);
}

//step 4 查询列及排序列添加至查询对象
if (orderColumns != null && orderColumns.size() > 0) {
    criteria.setOrderColumns(orderColumns);
}
if (filters != null && filters.size() > 0) {
    criteria.setFilters(filters);
}

//step 5 设置查询翻页配置
criteria.setPageNum(1);
criteria.setPageSize(20);

//step 6 实例化ES提供商
ElasticSearchProviders elasticSearchProviders = new ElasticSearchProviders();

//step 7 构建查询条件
SearchQuery searchQuery = elasticSearchProviders.buildSearchQuery(criteria);

//step 8 通过封装过的query方法得到查询结果BizResult
BizResult bizResult = repository.query(searchQuery);
```

## properties文件配置
```
spring.data.elasticsearch.repositories.enabled = true
spring.data.elasticsearch.cluster-nodes=127.0.0.1:9300,127.0.0.2:9300,127.0.0.3:9300
spring.data.elasticsearch.cluster-name=elasticsearch
```

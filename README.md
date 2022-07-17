<span style="color: red;">注:</span>

<ul>
    <li><code>src/main/resources</code>目录下省略了<code>db.properties</code>和<code>mail.properties</code>文件</li>
    <li><code>db.properties</code>文件中是<code>druid</code>数据源的配置信息</li>
    <li><code>mail.properties</code>文件中是邮件信息配置</li>
</ul>

``` properties
# db.properties
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/ssm
username=username
password=password
initialSize=100
maxActive=200
minIdle=30
```

``` properties
# mail.properties
# 协议
email.protocol=smtp
# 主机
email.host=smtp.163.com
# 端口
email.port=25
# 发送人
email.username=email-account
# 授权信息
email.password=the-password-for-smtp
# 默认编码
email.defaultEncoding=utf-8
# 检验
email.auth=true
# 超时时间
email.timeout=2000
```
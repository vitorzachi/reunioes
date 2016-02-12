<#import "/spring.ftl" as spring />

<#macro contentHeader header, optionalDescription="">
    <section class="content-header">
        <h1>
            Page Header
            <#if optionalDescription?has_content><small><@spring.message optionalDescription/></small></#if>
        </h1>
        <!-- espaço para breadcrumb aqui-->
    </section>
</#macro>


<#macro breadcrumb>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
    </ol>
</#macro>


<#macro content header, optionalDescription="">
    <!-- Content Header (Page header) -->
    <@contentHeader header optionalDescription />
    <!-- Main content -->
    <section class="content">

        <!-- Your Page Content Here -->
        <#nested>

    </section><!-- /.content -->
</#macro>
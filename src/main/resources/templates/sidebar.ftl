<#import "/spring.ftl" as spring />

<ul class="sidebar-menu">
    <li class="header"><@spring.message "app.menu"/></li>
    <!-- Optionally, you can add icons to the links -->

    <li class="active">
        <a href="#">
            <i class='fa fa-link'></i> <span><@spring.message "menu.agendar.reuniao"/></span>
        </a>
    </li>

    <li>
        <a href="#">
            <i class='fa fa-link'></i> <span><@spring.message "menu.proximas.reunioes"/></span>
        </a>
    </li>


    <li class="treeview">
        <a href="#"><i class='fa fa-link'></i> <span><@spring.message "menu.pautas"/></span> <i class="fa fa-angle-left pull-right"></i></a>
        <ul class="treeview-menu">
            <li><a href="#"><@spring.message "menu.pautas.abertas"/></a></li>
            <li><a href="#"><@spring.message "menu.pautas.minhas"/></a></li>
        </ul>
    </li>

    <li>
        <a href="#">
            <i class='fa fa-link'></i> <span><@spring.message "menu.gerenciar.grupos"/></span>
        </a>
    </li>
</ul>
package com.irubenmh.kmp.pizzeria.common.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.irubenmh.kmp.pizzeria.domain.model.BottomBarItem
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    title: StringResource,
    extraTitle: String? = null,
    actions: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    fabPosition: FabPosition = FabPosition.End,
    content: @Composable (PaddingValues) -> Unit
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val bottomBarItems = emptyList<BottomBarItem>()


    androidx.compose.material3.Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(0.9f),
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        MainText(
                            modifier = modifier,
                            text = stringResource(title, extraTitle ?: "").uppercase(),
                            initialFontSize = 20.sp,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }


                },
                actions = {
                    Row(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        actions.invoke()
                    }

                })
        }, bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary.copy(0.9f),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val ratio = 1f / bottomBarItems.size
                    bottomBarItems.forEach { bottomBarItem ->
                        val id = stringResource(bottomBarItem.id)
                        val isSelected = currentRoute == bottomBarItem.route
                        Column(
                            modifier = Modifier.weight(ratio),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            IconButton(modifier = Modifier.testTag(id)
                                .semantics { contentDescription = id }, onClick = {
                                navController.navigate(bottomBarItem.route)
                            }) {
                                Icon(
                                    painter = bottomBarItem.icon,
                                    contentDescription = stringResource(bottomBarItem.description),
                                    tint = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(
                                        0.5f
                                    )

                                )
                            }
                        }
                    }
                }
            }
        }, floatingActionButton = {
            floatingActionButton()
        },
        floatingActionButtonPosition = fabPosition,
        modifier = modifier
    ) { paddingValues ->
        content(paddingValues)
    }
}
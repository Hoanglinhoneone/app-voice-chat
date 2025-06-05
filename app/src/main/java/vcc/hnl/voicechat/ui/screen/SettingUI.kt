package vcc.hnl.voicechat.ui.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import vcc.hnl.voicechat.MainViewModel
import vcc.hnl.voicechat.ui.component.ModelDropdownMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetSetting(
    uiState: MainViewModel.UiState,
    mainViewModel: MainViewModel,
    onCloseSheet: () -> Unit,
    onSaveClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )

    ModalBottomSheet(
        containerColor = Color.White,
        onDismissRequest = {
            onCloseSheet()
        },
        sheetState = sheetState,
        modifier = Modifier
            .fillMaxWidth()
            .imePadding(),
        sheetMaxWidth = Dp.Unspecified
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = uiState.domain,
                onValueChange = {
                    mainViewModel.changeDomain(it)
                },
                label = {
                    Text(text = "Domain")
                },
                singleLine = true,
                maxLines = 1,
                placeholder = {
                    Text(text = "default: https://stallion-flying-burro.ngrok-free.app")
                },
                modifier = Modifier.fillMaxWidth()
            )

            uiState.modelInfo?.let {
                ModelDropdownMenu(
                    modelSelected = it,
                    models = uiState.models,
                    onClickedModel = {
                        mainViewModel.changeModel(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.End)
                )
            }

            Button(
                onClick = {
                    onSaveClicked()
                }
            ) {
                Text(
                    text = "Lưu"
                )
            }
        }
    }
}
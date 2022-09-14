import SwiftUI
import shared


@main
struct iOSApp: App {
    let sdk = NewsUseCase()
    var body: some Scene {
        WindowGroup {
            ContentView(viewModel: .init(sdk: sdk))
        }
    }
}

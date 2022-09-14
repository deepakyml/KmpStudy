import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    @ObservedObject private(set) var viewModel: ViewModel
    @State var showingDetail = false
    @State var newsArticle : NewsArticle? = nil

	var body: some View {
        NavigationView {
            if showingDetail{
                if(newsArticle != nil){
                    ExpandedNewsCard(article: newsArticle!,selector: {
                        self.showingDetail.toggle()
                    })
                }
                
            } else{
            listView()
            .navigationBarTitle("News")
            }
	}.padding()
    }
    
    private func listView() -> AnyView {
        switch viewModel.status {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let responses):
            return AnyView(List(responses, id: \.self) { response in
                Button (action: {
                    newsArticle = response
                    self.showingDetail.toggle()
                }) {
                NewsCard(article: response)
                }.listRowBackground(Color.black)
            })
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
    
}


extension ContentView {
    enum NewsApiResponse {
        case loading
        case result([NewsArticle])
        case error(String)
    }
    class ViewModel: ObservableObject {
        @Published var status = NewsApiResponse.loading
        let sdk: NewsUseCase
             init(sdk: NewsUseCase) {
                 self.sdk = sdk
                 getTopNews()
             }
        func getTopNews(){
            self.status = .loading
            sdk.fetchTopNews(completionHandler: {response, error in
                if response != nil{
                    self.status = .result(response!)
                }else{
                    self.status = .error(error?.localizedDescription ?? "error")
                }
                
            })
        }
        
    }
    
}
    

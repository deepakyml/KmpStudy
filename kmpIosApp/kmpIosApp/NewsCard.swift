
import SwiftUI
import shared
import AVKit


struct NewsCard: View {
    var article:NewsArticle
    var body: some View {
            VStack(alignment: .center,spacing: 0){
                if #available(iOS 15.0, *) {
                    AsyncImage(url: URL(string:article.urlToImage!)) { phase in
                        if let image = phase.image {
                            image.resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(minWidth: 100, maxHeight:  200)
                                .clipShape(RoundedRectangle(cornerSize: CGSize(width: 10,height: 10)))
                                .shadow(radius: 10)
                            // Displays the loaded image.
                        } else if phase.error != nil {
                            Color.red // Indicates an error.
                        } else {
                            Color.blue // Acts as a placeholder.
                        }
                    }
                } else {
                    // Fallback on earlier versions
                }
                Text(article.title!)
                    .frame(minWidth : 200, maxHeight:  300)
                    .font(.caption).foregroundColor(.white).padding().multilineTextAlignment(.leading).lineLimit(3).fixedSize(horizontal: false, vertical: true)
            }.background(Color.black)
            
    }
}

struct NewsCard_Previews: PreviewProvider {
    static var previews: some View {
        NewsCard(article : NewsArticle(author: "Author", content: "Content", description: "Description", publishedAt: "12/12/2022", title: "News Title", url: "some url", urlToImage: ImageUtils().getTodaysBotAvatar()))
    }
}

struct ExpandedNewsCard: View {
    var article:NewsArticle
    typealias MethodHandler = ()  -> Void
    var selector : MethodHandler
    @Environment(\.presentationMode) var presentationMode
    
    var btnBack : some View { Button(action: {
            selector()
            self.presentationMode.wrappedValue.dismiss()
            }) {
                HStack {
                Image("ic_back") // set image here
                    .aspectRatio(contentMode: .fit)
                    .foregroundColor(.white)
                    Text("Go back")
                }
            }
        }
    var body: some View {
        ZStack{
            ScrollView {
            VStack(alignment: .leading,spacing: 0){
                Text(article.title!)
                    .font(.title).padding().multilineTextAlignment(.leading)
                Divider()
                if #available(iOS 15.0, *) {
                    AsyncImage(url: URL(string:article.urlToImage!)) { phase in
                        if let image = phase.image {
                            image.resizable()
                                .aspectRatio(contentMode: .fit)
                                .clipShape(RoundedRectangle(cornerSize: CGSize(width: 10,height: 10)))
                                .frame(maxHeight: 400)
                                .shadow(radius: 10)
                            // Displays the loaded image.
                        } else if phase.error != nil {
                            Color.red // Indicates an error.
                        } else {
                            Color.blue // Acts as a placeholder.
                        }
                    }
                } else {
                    // Fallback on earlier versions
                }
                Divider()
                Text(article.content!)
                    .lineLimit(nil)
                    .font(.callout).padding().multilineTextAlignment(.leading)
                Text(article.description_!)
                    .lineLimit(nil)
                    .font(.body).padding().multilineTextAlignment(.leading)
            
        }.cornerRadius(10).overlay(RoundedRectangle(cornerRadius: 10).stroke(Color.gray.opacity(0.1)))
                .shadow(radius: 10)
            }
        }.padding().navigationBarBackButtonHidden(true)
            .navigationBarItems(leading: btnBack)
    }
}



struct ExpandedNewsCardPreviews: PreviewProvider {
    static var previews: some View {
        ExpandedNewsCard(article : NewsArticle(author: "Author", content: "Content", description: "Description", publishedAt: "12/12/2022", title: "News Title", url: "some url", urlToImage: ImageUtils().getTodaysBotAvatar()),selector: {})
    }
}




















extension Color {

    init?(hexString: String) {

        let rgbaData = getrgbaData(hexString: hexString)

        if(rgbaData != nil){

            self.init(
                        .sRGB,
                        red:     Double(rgbaData!.r),
                        green:   Double(rgbaData!.g),
                        blue:    Double(rgbaData!.b),
                        opacity: Double(rgbaData!.a)
                    )
            return
        }
        return nil
    }
}

extension UIColor {

    public convenience init?(hexString: String) {

        let rgbaData = getrgbaData(hexString: hexString)

        if(rgbaData != nil){
            self.init(
                        red:   rgbaData!.r,
                        green: rgbaData!.g,
                        blue:  rgbaData!.b,
                        alpha: rgbaData!.a)
            return
        }
        return nil
    }
}

private func getrgbaData(hexString: String) -> (r: CGFloat, g: CGFloat, b: CGFloat, a: CGFloat)? {

    var rgbaData : (r: CGFloat, g: CGFloat, b: CGFloat, a: CGFloat)? = nil

    if hexString.hasPrefix("#") {

        let start = hexString.index(hexString.startIndex, offsetBy: 1)
        let hexColor = String(hexString[start...]) // Swift 4

        let scanner = Scanner(string: hexColor)
        var hexNumber: UInt64 = 0

        if scanner.scanHexInt64(&hexNumber) {

            rgbaData = { // start of a closure expression that returns a Vehicle
                switch hexColor.count {
                case 8:

                    return ( r: CGFloat((hexNumber & 0xff000000) >> 24) / 255,
                             g: CGFloat((hexNumber & 0x00ff0000) >> 16) / 255,
                             b: CGFloat((hexNumber & 0x0000ff00) >> 8)  / 255,
                             a: CGFloat( hexNumber & 0x000000ff)        / 255
                           )
                case 6:

                    return ( r: CGFloat((hexNumber & 0xff0000) >> 16) / 255,
                             g: CGFloat((hexNumber & 0x00ff00) >> 8)  / 255,
                             b: CGFloat((hexNumber & 0x0000ff))       / 255,
                             a: 1.0
                           )
                default:
                    return nil
                }
            }()

        }
    }

    return rgbaData
}


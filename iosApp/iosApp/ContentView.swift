import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        VStack {
            Text(StringsKt.getMyDesc().localized())
                .foregroundColor(ColorsKt.getValueColor().toColor())
            Text(StringsKt.getMyFormatDesc(input: "이것은").localized())
                .foregroundColor(ColorsKt.getThemeColor().toColor())
            Text(StringsKt.getUserName(user: nil).localized())
            Text(StringsKt.getUserName(user: User(name: "wonddak", age: 27)).localized())
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


extension ColorResource {
    func toColor() -> SwiftUI.Color {
        return SwiftUI.Color(getUIColor())
    }
}

module Jekyll
  class MarkdownTracker
    @@count = 0
    @@total = 0
    @@start_time = nil

    class << self
      attr_accessor :count, :total, :start_time
    end
  end

  # Count total markdown files at the very beginning
  Jekyll::Hooks.register :site, :after_reset do |site|
    MarkdownTracker.count = 0
    MarkdownTracker.total = 0
    MarkdownTracker.start_time = Time.now
    
    STDERR.puts "\n" + "="*60
    STDERR.puts "🔍 Jekyll Build Started"
    STDERR.puts "="*60
    STDERR.flush
  end

  # Count files before rendering
  Jekyll::Hooks.register :site, :pre_render do |site|
    MarkdownTracker.total = site.pages.count { |p| p.name.end_with?('.md', '.markdown') }
    MarkdownTracker.total += site.posts.docs.count
    
    STDERR.puts "\n📝 Total markdown files to process: #{MarkdownTracker.total}"
    STDERR.puts "="*60 + "\n"
    STDERR.flush
  end

  # Track each page as it's rendered
  Jekyll::Hooks.register :pages, :post_render do |page|
    if page.name.end_with?('.md', '.markdown')
      MarkdownTracker.count += 1
      percentage = (MarkdownTracker.count.to_f / MarkdownTracker.total * 100).round(1)
      STDERR.puts "[#{MarkdownTracker.count}/#{MarkdownTracker.total}] (#{percentage}%) #{page.name}"
      STDERR.flush
    end
  end

  # Track posts
  Jekyll::Hooks.register :posts, :post_render do |post|
    MarkdownTracker.count += 1
    percentage = (MarkdownTracker.count.to_f / MarkdownTracker.total * 100).round(1)
    STDERR.puts "[#{MarkdownTracker.count}/#{MarkdownTracker.total}] (#{percentage}%) #{post.data['title'] || post.name}"
    STDERR.flush
  end

  # Summary at the end
  Jekyll::Hooks.register :site, :post_write do |site|
    elapsed = (Time.now - MarkdownTracker.start_time).round(2)
    
    STDERR.puts "\n" + "="*60
    STDERR.puts "✅ Build Complete!"
    STDERR.puts "   Processed: #{MarkdownTracker.count} files"
    STDERR.puts "   Time: #{elapsed} seconds"
    STDERR.puts "   Average: #{(elapsed / MarkdownTracker.count).round(3)}s per file"
    STDERR.puts "="*60 + "\n"
    STDERR.flush
  end
end